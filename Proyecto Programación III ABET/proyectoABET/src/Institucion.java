import java.util.*;

public class Institucion {
    private ArrayList<FuncionarioEcuatoriano> funcionarios;

    public Institucion() {
        funcionarios = new ArrayList<>();
    }

    public boolean registrarEmpleado(String cedula, String nombre, double sueldo) {
        for (FuncionarioEcuatoriano funci : funcionarios) {
            if (funci.getCedula().equals(cedula)) {
                return false;
            }
        }
        FuncionarioEcuatoriano empleado = new FuncionarioEcuatoriano(cedula, nombre, sueldo);
        funcionarios.add(empleado);
        return true;
    }

    public FuncionarioEcuatoriano modificarFuncionario(String cedula, String nombre, double sueldo) {
        for (FuncionarioEcuatoriano emp : funcionarios) {
            if (emp.getCedula().equals(cedula)) {
                emp.setNombre(nombre);
                emp.setSueldo(sueldo);
                return emp;
            }
        }
        return null;
    }

    public String generarInforme() {
        String text = "";
        for (FuncionarioEcuatoriano funcionarioecuatoriano : funcionarios) {
            text += funcionarioecuatoriano.toString() + "\n";
        }
        return text;
    }

    public String listarFuncionarios() {
        String text = "";
        for (FuncionarioEcuatoriano funcionarioec : funcionarios) {
            text += funcionarioec.getNombre() + "\n";
        }
        return text;
    }
}
