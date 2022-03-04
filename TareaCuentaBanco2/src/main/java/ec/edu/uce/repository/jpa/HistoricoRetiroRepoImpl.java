package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.HistoricoRetiros;

@Repository
@Transactional
public class HistoricoRetiroRepoImpl implements IHistoricoRetirosRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarRetiro(HistoricoRetiros retiro) {
		this.entityManager.persist(retiro);
	}

	@Override
	public void ActualizarHistoricoRetiros(HistoricoRetiros retiro) {
		this.entityManager.merge(retiro);
	}

	@Override
	public HistoricoRetiros BuscarPorNumero(String numero) {
		Query miQuery= this.entityManager.createNativeQuery("select h from historico_retiros h, cuenta_bancaria c where h.cuentah_id=c.cuenta_id and c.cuba_numero=:valor",HistoricoRetiros.class);
		miQuery.setParameter("valor", numero);
		return (HistoricoRetiros) miQuery.getSingleResult();
	}

	@Override
	public void BorrarHistoricoRetiros(String numero) {
		HistoricoRetiros borrado=this.BuscarPorNumero(numero);
		this.entityManager.remove(borrado);
	}

}
