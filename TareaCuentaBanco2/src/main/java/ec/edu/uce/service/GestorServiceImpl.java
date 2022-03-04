package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.modelo.jpa.CuentaHabiente;
import ec.edu.uce.modelo.jpa.HistoricoRetiros;

@Service
public class GestorServiceImpl implements IGestorService{

	private static final Logger LOG= LogManager.getLogger(GestorServiceImpl.class);
	
	@Autowired
	private ICuentaBancariaService cuentaServ;
	
	@Autowired
	private ICuentaHabienteService habienteService;
	
	@Autowired
	private IHistoricoRetirosService retiroService;
	
	@Override
	@Transactional
	public void ConsultarCuentas(String cedula) {
		
		CuentaHabiente ch = this.habienteService.BuscarPorCedulaService(cedula);
		List<CuentaBancaria> cb = ch.getCuenta_bancaria();

		LOG.info("Las cuentas del usuario: "+ch.getNombre()+" "+ch.getApellido()+ " han sido: ");
		LOG.info(cb.toString());
	}

	@Override
	@Transactional
	public void RetirarDinero(String numero, BigDecimal retiro) {
		CuentaBancaria cb=this.cuentaServ.BuscarPorNumeroService(numero);
		HistoricoRetiros hr=new HistoricoRetiros();
		CuentaHabiente ch=cb.getCuenta_habiente();
		
		BigDecimal valorActual=cb.getSaldo().subtract(retiro);
		LocalDateTime ahora=LocalDateTime.now();
		hr.setMonto(retiro);
		hr.setFechaRetiro(ahora);
		cb.setSaldo(valorActual);
		
		hr.setCuenta_bancaria(cb);
		hr.setCuenta_habiente(ch);
		
		cuentaServ.ActualizarCuentaBancariaService(cb);
		retiroService.ActualizarHistoricoRetirosService(hr);
	}

	@Override
	public void ConsultarSaldo(String numeroCuenta) {
		CuentaBancaria cb=this.cuentaServ.BuscarPorNumeroService(numeroCuenta);
		
		LOG.info("El saldo de la cuenta ingresada es: "+cb.getSaldo());
	}

}
