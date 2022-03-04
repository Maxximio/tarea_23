package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.modelo.jpa.CuentaHabiente;

@Repository
@Transactional
public class CuentaHabienteRepoImpl implements ICuentaHabienteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarCuentaHabiente(CuentaHabiente cuentah) {
		this.entityManager.persist(cuentah);
	}

	@Override
	public void ActualizarCuentaHabiente(CuentaHabiente cuentah) {
		this.entityManager.merge(cuentah);
	}

	@Override
	public CuentaHabiente BuscarPorCedula(String cedula) {
		Query miQuery= this.entityManager.createNativeQuery("select * from cuenta_habiente h where h.habiente_cedula=:valor",CuentaHabiente.class);
		miQuery.setParameter("valor", cedula);
		return (CuentaHabiente) miQuery.getSingleResult();
	}

	@Override
	public void BorrarCuentaHabiente(String cedula) {
		CuentaHabiente borrado=this.BuscarPorCedula(cedula);
		this.entityManager.remove(borrado);
	}

}
