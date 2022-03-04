package ec.edu.uce.modelo.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cuenta_habiente")
public class CuentaHabiente {

	@Id
	@Column(name="habiente_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habiente")
	@SequenceGenerator(name="seq_habiente",sequenceName = "seq_habiente",allocationSize = 1)
	private Integer id;
		
	@Column(name="habiente_nombre")
	private String nombre;
	
	@Column(name="habiente_apellido")
	private String apellido;
	
	@Column(name="habiente_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "cuenta_habiente",cascade=CascadeType.ALL)
	private List<HistoricoRetiros> historico_retiros;
	
	@OneToMany(mappedBy = "cuenta_habiente",cascade=CascadeType.ALL)
	private List<CuentaBancaria> cuenta_bancaria;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<HistoricoRetiros> getHistorico_retiros() {
		return historico_retiros;
	}

	public void setHistorico_retiros(List<HistoricoRetiros> historico_retiros) {
		this.historico_retiros = historico_retiros;
	}

	public List<CuentaBancaria> getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(List<CuentaBancaria> cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}
	
	
}
