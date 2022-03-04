package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.CuentaHabiente;

public interface ICuentaHabienteRepo {

	void InsertarCuentaHabiente(CuentaHabiente cuentah);
	
	void ActualizarCuentaHabiente(CuentaHabiente cuentah);
	
	CuentaHabiente BuscarPorCedula(String cedula);
	
	void BorrarCuentaHabiente(String cedula);
	
}
