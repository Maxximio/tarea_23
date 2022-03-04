package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CuentaHabiente;
import ec.edu.uce.repository.jpa.ICuentaHabienteRepo;

@Service
public class CuentaHabienteServiceImpl implements ICuentaHabienteService{

	@Autowired
	private ICuentaHabienteRepo habienteRepo;
	
	@Override
	public void InsertarCuentaHabienteService(CuentaHabiente cuentah) {
		this.habienteRepo.InsertarCuentaHabiente(cuentah);
	}

	@Override
	public void ActualizarCuentaHabienteService(CuentaHabiente cuentah) {
		this.habienteRepo.ActualizarCuentaHabiente(cuentah);
	}

	@Override
	public CuentaHabiente BuscarPorCedulaService(String cedula) {
		return this.habienteRepo.BuscarPorCedula(cedula);
	}

	@Override
	public void BorrarCuentaHabienteService(String cedula) {
		this.habienteRepo.BorrarCuentaHabiente(cedula);
	}

}
