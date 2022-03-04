package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.HistoricoRetiros;

public interface IHistoricoRetirosRepo {

	void InsertarRetiro(HistoricoRetiros retiro);
	
	void ActualizarHistoricoRetiros(HistoricoRetiros retiro);
	
	HistoricoRetiros BuscarPorNumero(String numero);
	
	void BorrarHistoricoRetiros(String numero);
}
