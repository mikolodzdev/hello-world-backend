package hello;

public class Fibonacci {
    public Long of;
    public Long fibonacci;

    public Fibonacci() {
    }

    public Fibonacci(Long of, Long fibonacci) {
        this.of = of;
        this.fibonacci = fibonacci;
    }

    public Long getOf() {
        return of;
    }

    public void setOf(Long of) {
        this.of = of;
    }

    public Long getFibonacci() {
        return fibonacci;
    }

    public void setFibonacci(Long fibonacci) {
        this.fibonacci = fibonacci;
    }
}
