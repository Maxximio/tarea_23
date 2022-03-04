package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.HistoricoRetiros;
import ec.edu.uce.repository.jpa.IHistoricoRetirosRepo;

@Service
public class HistoricoRetirosServiceImpl implements IHistoricoRetirosService{

	@Autowired
	private IHistoricoRetirosRepo histoRepo;
	
	@Override
	public void InsertarRetiroService(HistoricoRetiros retiro) {
		this.histoRepo.InsertarRetiro(retiro);
	}

	@Override
	public void ActualizarHistoricoRetirosService(HistoricoRetiros retiro) {
		this.histoRepo.ActualizarHistoricoRetiros(retiro);
	}

	@Override
	public HistoricoRetiros BuscarPorNumeroService(String numero) {
		return this.histoRepo.BuscarPorNumero(numero);
	}

	@Override
	public void BorrarHistoricoRetirosService(String numero) {
		this.histoRepo.BorrarHistoricoRetiros(numero);
	}

}
