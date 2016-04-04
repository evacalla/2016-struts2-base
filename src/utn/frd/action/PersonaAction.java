package utn.frd.action;

import java.util.List;
import utn.frd.bean.PersistentManager;
import utn.frd.bean.Persona;

public class PersonaAction {
	
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

		new Persona(personas.size(), name, edad, gender);
		
		return SUCCESS;
	}
	public String execute(){
		personas = PersistentManager.getInstance();
		
		return SUCCESS;
	}

}