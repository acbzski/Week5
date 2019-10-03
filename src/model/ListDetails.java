package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="SELL_DATE")
	private LocalDate sellDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinTable(name="CARS_ON_LIST",
			joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
			inverseJoinColumns={ @JoinColumn(name="CAR_ID", referencedColumnName="ID", unique=true) })
	private List<Car> listOfCars;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate sellDate, Owner owner, List<Car> listOfCars) {
		super();
		this.id = id;
		this.listName = listName;
		this.sellDate = sellDate;
		this.owner = owner;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate sellDate, Owner owner, List<Car> listOfCars) {
		super();
		this.listName = listName;
		this.sellDate = sellDate;
		this.owner = owner;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate sellDate, Owner owner) {
		super();
		this.listName = listName;
		this.sellDate = sellDate;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getSellDate() {
		return sellDate;
	}
	public void setSellDate(LocalDate sellDate) {
		this.sellDate = sellDate;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Car> getListOfCars() {
		return listOfCars;
	}
	public void setListOfCars(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", sellDate=" + sellDate + ", owner=" + owner
				+ ", listOfCars=" + listOfCars + "]";
	}
	
	
}
