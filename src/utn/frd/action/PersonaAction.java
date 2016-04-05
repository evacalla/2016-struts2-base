package utn.frd.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import db.PersistentManager;
import utn.frd.bean.Persona;

public class PersonaAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String age;
	private String gender; 
	private List<Persona> personas;

	
	public String save(){ 
		personas = PersistentManager.getInstance(); 
		int edad = 0; 
		 
		try{ 
		edad = Integer.parseInt(age); 
		}catch(Exception e){ 
		addActionError("Ocurrió un error con la edad"); 
		return ERROR; 
		} 
		 
		try{
		Persona p = new Persona(personas.size(), name, edad, gender); //creo la persona
		personas.add(p);//agrego una persona a la lista personas
		System.out.println(personas.size());
		}catch(Exception e){
			addActionError("Ocurrio un error al crear la persona");
			return ERROR;
		}
		
	
		return SUCCESS; 
		}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public String execute(){//inicializar coleccion
		personas = PersistentManager.getInstance();
		
		return SUCCESS;
	}
	
	public void delete(long id){
		personas.remove(id);
		
	}
	
	public void edit(long id){
		//TODO
	}

}