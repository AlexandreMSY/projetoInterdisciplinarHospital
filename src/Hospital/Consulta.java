package Hospital;

public class Consulta extends Forma{
    private Paciente paciente;
    private Doutor doutor;
    private String dataConsulta;

    public Consulta(Paciente paciente, Doutor doutor, String dataConsulta) {
        this.paciente = paciente;
        this.doutor = doutor;
        this.dataConsulta = dataConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doutor getDoutor() {
        return doutor;
    }

    public void setDoutor(Doutor doutor) {
        this.doutor = doutor;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @Override
    public void print() {
        System.out.println("Nome do paciente: " + this.getPaciente().getNome());
        System.out.println("Doutor: " + this.getDoutor().getNome());
        System.out.println("Especialidade Doutor: " + this.getDoutor().getEspecialidade());
        System.out.println("Data Colsulta: " + this.getDataConsulta());
    }
}
