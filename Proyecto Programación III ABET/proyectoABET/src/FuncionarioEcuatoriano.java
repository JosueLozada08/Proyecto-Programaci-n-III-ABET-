public class FuncionarioEcuatoriano {
    private String cedula, nombre;
    private double sueldo;

    public FuncionarioEcuatoriano(String cedula, String nombre, double sueldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    //Metodos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double CalculoImpuestoALaRenta() {

        double ingresoAnual = sueldo * 12;


//Calculos en funcion a porcentajes del Estado ecuatoriano
        if (ingresoAnual <= 11722) {
            return 0;
        } else if (ingresoAnual>11722 && ingresoAnual <= 14935) {
            return ingresoAnual * 0.05;
        } else if (ingresoAnual>14935 && ingresoAnual <= 18666) {
            return ingresoAnual * 0.1;
        } else if (ingresoAnual>18666 && ingresoAnual <= 22418) {
            return ingresoAnual * 0.12;
        } else if (ingresoAnual>22418 && ingresoAnual <= 32783) {
            return ingresoAnual * 0.15;
        } else if (ingresoAnual>32783 && ingresoAnual <= 43147) {
            return ingresoAnual * 0.2;
        } else if (ingresoAnual>43147 && ingresoAnual <= 53512) {
            return ingresoAnual * 0.25;
        } else if (ingresoAnual>53512 && ingresoAnual <= 63876) {
            return ingresoAnual * 0.3;
        } else if (ingresoAnual>63876 && ingresoAnual <= 103644) {
            return ingresoAnual * 0.35;

        } else {
            return ingresoAnual * 0.37;
        }
    }
// Se calcula el Aporte al Seguro Social (9.45% del sueldo)
    public double CalculoAporteAlSeguroSocial() {
        return this.sueldo * 0.0945;
    }

    public String toString() {
        String text = "";
        text += "Cédula del funcionario: " + getCedula() + "\n";
        text += "Nombre del funcionario: " + getNombre() + "\n";
        text += "Sueldo mensual: " + getSueldo() + "\n";
        text += "Impuesto a la renta a pagar: " + CalculoImpuestoALaRenta() + "\n";
        text += "Aporte al seguro social: " + CalculoAporteAlSeguroSocial() + "\n";
        text += "Sueldo a recibir de manera anual: " + ((getSueldo()*12) - (CalculoAporteAlSeguroSocial()*12) - CalculoImpuestoALaRenta()) + "\n";
        return text;
    }


}
