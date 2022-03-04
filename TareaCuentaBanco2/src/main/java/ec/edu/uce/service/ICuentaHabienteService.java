package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.CuentaHabiente;

public interface ICuentaHabienteService {

	void InsertarCuentaHabienteService(CuentaHabiente cuentah);
	
	void ActualizarCuentaHabienteService(CuentaHabiente cuentah);
	
	CuentaHabiente BuscarPorCedulaService(String cedula);
	
	void BorrarCuentaHabienteService(String cedula);
}
