package Modelo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListPCWrapper {
	private List<PC> pcList;
	
	public ListPCWrapper() { }
	
	@XmlElement(name = "PC")
	public List<PC> getPCList() {
		return pcList;
	}
	public void setPCList(List<PC> list) {
		pcList = list;
	}

}
