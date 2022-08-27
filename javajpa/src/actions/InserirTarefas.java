package actions;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class InserirTarefas {
	public static void main(String[] args) {
		Tarefa tarefa1 = new Tarefa();
		
		//objeto 1
		tarefa1.setDescricao("Estudar Spring Sempre!");
		tarefa1.setFinalizada(false);
		tarefa1.setDataFinalizacao(Calendar.getInstance());
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(tarefa1);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa inserida, ID: " + tarefa1.getId());
		
		manager.close();
		factory.close();
	}
}
