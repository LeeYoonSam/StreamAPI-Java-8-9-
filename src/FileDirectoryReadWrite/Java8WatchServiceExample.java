package FileDirectoryReadWrite;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.StandardWatchEventKinds;

/**
 * URL - https://howtodoinjava.com/java-8/java-8-watchservice-api-tutorial/
 */
public class Java8WatchServiceExample {

    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;

    // 초기화
    public Java8WatchServiceExample(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey, Path>();

        walkAndRegisterDirectories(dir);
    }

    // 경로를 WatchKey 해시맵에 저장해서 캐시 처리
    private void registerDirectory(Path dir) throws  IOException {
        WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        keys.put(key, dir);
    }

    // 폴더 모니터링
    private void walkAndRegisterDirectories(final Path start) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                registerDirectory(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    // 옵저버 역할 - 파일 추가, 수정, 삭제 이벤트 발생시
    void processEvents() {
        for (;;) {
            WatchKey key = null;

            try {
                key = watcher.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Path dir = keys.get(key);

            if(dir == null) {
                System.err.println("WatchKey not recognized!");
                continue;
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();

                Path name = ((WatchEvent<Path>) event).context();
                Path child = dir.resolve(name);

                System.out.format("%s: %s\n", event.kind().name(), child);

                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    try {
                        if (Files.isDirectory(child)) {
                            walkAndRegisterDirectories(child);
                        }
                    } catch (IOException x) {
                        // do something useful
                    }
                }

            }

            // reset key and remove from set if directory no longer accessible
            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);

                // all directories are inaccessible
                if (keys.isEmpty()) {
                    break;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        // Test 폴더를 모니터링 하며 변하가 생길때 이벤트가 발생한다
        Path dir = Paths.get("./Test/");
        new Java8WatchServiceExample(dir).processEvents();
    }
}
