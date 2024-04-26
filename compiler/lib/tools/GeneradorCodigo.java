
public abstract class GeneradorCodigo {}
public abstract class NoGenerar extends GeneradorCodigo {}
public abstract class Generar extends GeneradorCodigo {}


public interface PCodeFunctions {
    // procs generar codigo
}

public class PCodeGeneration<Generar> implements PCodeFunctions {
    
}

public class PCodeFunctions<NoGenerar> {
    // procs generar codigo
}

