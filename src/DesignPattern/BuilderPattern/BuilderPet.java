package DesignPattern.BuilderPattern;

public class BuilderPet {
    public static class Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;

        public Builder withA(final String a) {
            this.a = a;
            return this;
        }

        public Builder withB(final String b) {
            this.b = b;
            return this;
        }

        public Builder withC(final String c) {
            this.c = c;
            return this;
        }

        public Builder withD(final String d) {
            this.d = d;
            return this;
        }

        public Builder withE(final String e) {
            this.e = e;
            return this;
        }

        public Builder withF(final String f) {
            this.f = f;
            return this;
        }

        public BuilderPet build() {
            if(a == null ||
                    b == null ||
                    c == null ||
                    d == null)
                throw new IllegalStateException("Cannot create BuilderPet");

            return new BuilderPet(a, b, c, d, e, f);
        }
    }

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    private BuilderPet(String a, String b, String c, String d, String e, String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }
}

