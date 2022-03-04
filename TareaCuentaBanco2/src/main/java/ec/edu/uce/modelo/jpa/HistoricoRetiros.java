package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="historico_retiros")
public class HistoricoRetiros {

	@Id
	@Column(name="retiros_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_retiros")
	@SequenceGenerator(name="seq_retiros",sequenceName = "seq_retiros",allocationSize = 1)
	private Integer id;
	
	@Column(name="retiros_monto")
	private BigDecimal monto;
	
	@Column(name="retiros_fecha_retiro")
	private LocalDateTime fechaRetiro;
	
	@ManyToOne
	@JoinColumn(name="cuba_id")
	private CuentaBancaria cuenta_bancaria;
	
	@ManyToOne
	@JoinColumn(name="habiente_id")
	private CuentaHabiente cuenta_habiente;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(LocalDateTime fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public CuentaBancaria getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(CuentaBancaria cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}

	public CuentaHabiente getCuenta_habiente() {
		return cuenta_habiente;
	}

	public void setCuenta_habiente(CuentaHabiente cuenta_habiente) {
		this.cuenta_habiente = cuenta_habiente;
	}
	
	
	
}

