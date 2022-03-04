package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarCuentaBancaria(CuentaBancaria cuenta) {
		this.entityManager.persist(cuenta);
	}

	@Override
	public void ActualizarCuentaBancaria(CuentaBancaria cuenta){
		this.entityManager.merge(cuenta);
	}

	@Override
	public CuentaBancaria BuscarPorNumero(String numero) {
		Query miQuery= this.entityManager.createNativeQuery("select * from cuenta_bancaria c where c.cuba_numero=:valor",CuentaBancaria.class);
		miQuery.setParameter("valor", numero);
		return (CuentaBancaria) miQuery.getSingleResult();
	}

	@Override
	public void BorrarCuentaBancaria(String numero) {
		CuentaBancaria borrado=this.BuscarPorNumero(numero);	
		this.entityManager.remove(borrado);
	}

}
