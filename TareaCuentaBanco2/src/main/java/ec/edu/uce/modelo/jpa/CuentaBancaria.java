package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@Column(name="cuba_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuba")
	@SequenceGenerator(name="seq_cuba",sequenceName = "seq_cuba",allocationSize = 1)
	private Integer id;
	
	@Column(name="cuba_numero")
	private String numero;
	
	@Column(name="cuba_saldo")
	private BigDecimal saldo;
	
	@Column(name="cuba_tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="habiente_id")
	private CuentaHabiente cuenta_habiente;
	
	//@OneToMany(mappedBy = "cuenta_bancaria",cascade=CascadeType.ALL)
	//private List<HistoricoRetiros> historico_retiros;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public CuentaHabiente getCuenta_habiente() {
		return cuenta_habiente;
	}

	public void setCuenta_habiente(CuentaHabiente cuenta_habiente) {
		this.cuenta_habiente = cuenta_habiente;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}
	
	
	
}
