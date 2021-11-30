import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="office_number")
	private String office_number;
	
	@Column(name="research_area")
	private String research_area;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Professor() {
		
	}
	
	public Professor(String officeNum, String researchArea) {
		
		this.office_number = officeNum;
		this.research_area = researchArea;
		
	}
	
	public int getID() {
		
		return id;
	}
	
	public void setID(int id) {
	
		this.id = id;
	}
	
	public String getOfficeNum() {
		
		return office_number;
	}
	
	public void setOfficeNum(String officeNum) {
		
		this.office_number = officeNum;
	}
	
	public String getResearchArea() {
		
		return research_area;
	}
	
	public void setResearchArea(String researchArea) {
		
		this.research_area = researchArea;
	}
	
	public Customer getCustomer() {
		
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		
		this.customer = customer;
		
	}
	

}
