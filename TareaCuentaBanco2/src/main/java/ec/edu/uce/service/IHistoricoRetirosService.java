package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.HistoricoRetiros;

public interface IHistoricoRetirosService {

	void InsertarRetiroService(HistoricoRetiros retiro);
	
	void ActualizarHistoricoRetirosService(HistoricoRetiros retiro);
	
	HistoricoRetiros BuscarPorNumeroService(String numero);
	
	void BorrarHistoricoRetirosService(String numero);
}
