package ec.edu.uce.service;

import java.math.BigDecimal;

public interface IGestorService {

	void ConsultarCuentas(String cedula);
	
	void RetirarDinero(String numero,BigDecimal retiro);
	
	void ConsultarSaldo(String numeroCuenta);
	
}
