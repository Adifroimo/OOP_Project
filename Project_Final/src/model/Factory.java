package model;
	
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import Exceptions.IncorrectNumberOfSeats;
import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import Exceptions.PoullutionLevelHybridVehiclesMustBeOne;
import Exceptions.PoullutionLevelNotInRange;
import Exceptions.YearOfBirthNotInRange;
import model.BestDealCompare;
import model.Car;
import model.CompareManager;
import model.ComparePollution;
import model.Customer;
import model.Deal;
import model.DealCompare;
import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.HybridCar;
import model.HybridMotorcycle;
import model.Motorcycle;
import model.Person;
import model.ScoreCalculator;
import model.VIPCustomer;
import model.Van;
import model.VehicleTransportation;
import utils.Area;
import utils.Color;
import utils.Gender;	
/**@author adifroimovich 318173879 */
/** Factory is a singleton class, using getInstance we make sure that we wont be able to create another class of the type Factory
 * @return single_instance */
	public class Factory implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private HashMap<String,Employee> allEmployees;
		private HashMap<String,Customer> allCustomers;
		private HashMap<String,VehicleTransportation> allVehicleTransportation;
		private HashMap<String,Deal> allDeals;
		private HashMap<Integer,Department> allDepartments;
		
		private static Factory factory;
		private Factory() {
			allEmployees = new HashMap<String,Employee>();
			allCustomers = new HashMap<String, Customer>();
			allVehicleTransportation = new HashMap<String, VehicleTransportation>();
			allDeals = new HashMap<String, Deal>();
			allDepartments = new HashMap<Integer, Department>();
		}
		
		public static Factory getInstance() {
			if(factory == null)
				factory = new Factory();
			return factory; 
		}
		 
		
		//add functions 
		/**in addEmployee we've added to the allEmployees + to department he is working at! */ 
		public boolean addEmployee(Employee c) throws PersonAlreadyExistException, YearOfBirthNotInRange {
			if(c == null) {
				return false;
			}
			if(allEmployees.containsKey(c.getID())) {
				throw new PersonAlreadyExistException(c.getFirstName(),c.getLastName());
			}
			if(!(1900<c.getYearOfBirth()) || !(c.getYearOfBirth()<2022)) {
				throw new YearOfBirthNotInRange(c.getID());
				
			}
			allEmployees.put(c.getID(), c);
			 c.getDep().getAllEmployees().add(c);
			return true;
			
		}

			
		
		public boolean addDepartmentManager(DepartmentManager c) throws PersonAlreadyExistException, YearOfBirthNotInRange {
			if(c == null) {
				return false;
			}
			if(allEmployees.containsKey(c.getID())) {
				throw new PersonAlreadyExistException(c.getFirstName(),c.getLastName());
			}
			if(!(1900<c.getYearOfBirth()) || !(c.getYearOfBirth()<2022)) {
				throw new YearOfBirthNotInRange(c.getID());
			}
			allEmployees.put(c.getID(), c);
			c.getDep().setDepManager(c);
			return true;
			}
			
		
		public boolean addCustomer(Customer c) throws PersonAlreadyExistException, YearOfBirthNotInRange {
			if(c == null)
				return false;
			if(allCustomers.containsKey(c.getID())) {
				throw new PersonAlreadyExistException(c.getFirstName(),c.getLastName());
			}
			if(!(1900<c.getYearOfBirth()) || !(c.getYearOfBirth()<2022)) {
				throw new YearOfBirthNotInRange(c.getID());
			}
			allCustomers.put(c.getID(), c);
			return true;
		}
		public boolean addVIPCustomer(VIPCustomer c) throws PersonAlreadyExistException, YearOfBirthNotInRange {
				if(c == null)
					return false;
				if(allCustomers.containsKey(c.getID())) {
					throw new PersonAlreadyExistException(c.getFirstName(),c.getLastName());
				}
				if(!(1900<c.getYearOfBirth()) || !(c.getYearOfBirth()<2022)) {
					throw new YearOfBirthNotInRange(c.getID());
					
				}
				allCustomers.put(c.getID(), c);
				return true;
				}

				
		public boolean addCar(Car c) throws PoullutionLevelNotInRange, IncorrectNumberOfSeats  {
			if(c == null)
				return false;
				if(c.getPollutionLevel()<1 || c.getPollutionLevel()>15) {
					throw new PoullutionLevelNotInRange(c.getLicensePlate());
				}
				if(c.getNumberOfSeats()>7) {
					throw new IncorrectNumberOfSeats(c.getLicensePlate());
				}
				allVehicleTransportation.put(c.getLicensePlate(), c);
				return true; 
			
		}
		public boolean addHybridCar(HybridCar hybridCar) throws IncorrectNumberOfSeats, PoullutionLevelHybridVehiclesMustBeOne       {
			if(hybridCar == null)
				return false;
			if(hybridCar.getNumberOfSeats()>7) {
				throw new IncorrectNumberOfSeats(hybridCar.getLicensePlate());
			}
			if(hybridCar.getPollutionLevel()!=1) {
				throw new PoullutionLevelHybridVehiclesMustBeOne(hybridCar.getLicensePlate());
			}
			allVehicleTransportation.put(hybridCar.getLicensePlate(), hybridCar);
			return true; 
			
		}
		public boolean addVan(Van v) throws PoullutionLevelNotInRange {
			if(v == null)
				return false;
				if(v.getPollutionLevel()<1 || v.getPollutionLevel()>15) {
						throw new PoullutionLevelNotInRange(v.getLicensePlate());}
			allVehicleTransportation.put(v.getLicensePlate(), v);
			return true;
			}
		
		public boolean addMotorcycle(Motorcycle v) throws PoullutionLevelNotInRange {
			if(v == null)
				return false;
			if(v.getPollutionLevel()<1 || v.getPollutionLevel()>15) {
					throw new PoullutionLevelNotInRange(v.getLicensePlate());}
			allVehicleTransportation.put(v.getLicensePlate(), v);
			return true;
			}


		
		public boolean addHybridMotorcycle(HybridMotorcycle hybridMotorcycle) throws PoullutionLevelHybridVehiclesMustBeOne {
			if(hybridMotorcycle == null)
				return false;
			if(hybridMotorcycle.getPollutionLevel()!=1) {
				throw new PoullutionLevelHybridVehiclesMustBeOne(hybridMotorcycle.getLicensePlate());
			}
			allVehicleTransportation.put(hybridMotorcycle.getLicensePlate(), hybridMotorcycle);
			return true; 
			}



		public boolean addDepartment(Department d) {
			if(d ==null)
				return false;
			if(allDepartments.containsKey(d.getDepartmentID()))
				return false;
			allDepartments.put(d.getDepartmentID(), d);
			return true;
		} 
		public boolean addDeal(Deal d) {
			if(d == null) {
				return false;
			}

			d.getCustomer().getAllDeals().add(d);
			allDeals.put(d.getDealID(), d);
			return true;
		}
		
		//remove functions 
		public boolean removeCar(Car car){
			if(car == null)
				return false;
			if(!allVehicleTransportation.containsKey(car.getLicensePlate()))
				return false;
			allVehicleTransportation.remove(car.getLicensePlate());
			return true;
			
		}
		
		public boolean removeVan(Van van){
			
			if(van == null)
				return false;
			if(!allVehicleTransportation.containsKey(van.getLicensePlate()))
				return false;
			allVehicleTransportation.remove(van.getLicensePlate());
			return true;
			
		}
		public boolean removeMotorcycle(Motorcycle motorcycle){
			
			if(motorcycle == null)
				return false;
			if(!allVehicleTransportation.containsKey(motorcycle.getLicensePlate()))
				return false;
			allVehicleTransportation.remove(motorcycle.getLicensePlate());
			return true;
			
		}
		public boolean removeHybridCar(HybridCar hybridCar) {		
			if(hybridCar == null)
				return false;
			if(!allVehicleTransportation.containsKey(hybridCar.getLicensePlate()))
				return false;
			allVehicleTransportation.remove(hybridCar.getLicensePlate());
			return true;
			
		}
		public boolean removeHybridMotorcycle(HybridMotorcycle HybridMotorcycle){		
			if(HybridMotorcycle == null)
				return false;
			if(!allVehicleTransportation.containsKey(HybridMotorcycle.getLicensePlate()))
				return false;
			allVehicleTransportation.remove(HybridMotorcycle.getLicensePlate());
			return true;
			
		}
	 
		public boolean removeCustomer(Customer customer) throws PersonNotExistException{
			if(customer == null)
				throw new PersonNotExistException();
			if(!allCustomers.containsKey(customer.getID())) {
				throw new PersonNotExistException();
			}
			allCustomers.remove(customer.getID());
			return true;
		}

		public boolean removeVIPCustomer(VIPCustomer customer) throws PersonNotExistException{
			if(customer == null)
				throw new PersonNotExistException();
			if(!allCustomers.containsKey(customer.getID())) {
				throw new PersonNotExistException();}
			
			allCustomers.remove(customer.getID());
			return true;
			}
		

		public boolean removeEmployee(Employee employee) throws PersonNotExistException{
			if(employee == null)
				throw new PersonNotExistException();
			if(!allEmployees.containsKey(employee.getID())) {
				throw new PersonNotExistException();}
			allEmployees.remove(employee.getID());
			employee.getDep().getAllEmployees().remove(employee);
			return true;
			}
		
		public boolean removeDepartmentManager(DepartmentManager departmentManager) throws PersonNotExistException{
			if(departmentManager == null)
				throw new PersonNotExistException();
			if(!allEmployees.containsKey(departmentManager.getID())) {
				throw new PersonNotExistException();}
			
			allEmployees.remove(departmentManager.getID());
			departmentManager.getDep().setDepManager(null);
			return true;
			}
		/**in Deal add and remove, we're adding the deal both for the customer list of deals and to the allDeals list! */
		public boolean removeDeal(Deal deal){ 
			if(deal == null)
				return false;
			if(!allDeals.containsKey(deal.getDealID()))
				return false;
			deal.getCustomer().getAllDeals().remove(deal);
			allDeals.remove(deal.getDealID());
			return true;
		}
		
		/** in  removeDepartmentManager we will remove also from the allEmployees hashmap !!*/
		public boolean removeDepartment(Department department){
			if(department == null) {
				return false;
			}
			if(!allDepartments.containsKey(department.getDepartmentID()))
				return false;
			for(Employee e: department.getAllEmployees()) {
				allEmployees.remove(e.getID());	
			}
			if(department.getDepManager()!=null) {
			allEmployees.remove(department.getDepManager().getID());
			}
			allDepartments.remove(department.getDepartmentID());
			return true;
			
		}

		//getreal functions 
		//Note: We assume that in our system, a string cannot be null.
		public VehicleTransportation getRealVehicleTransportation(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return allVehicleTransportation.get(licensePlate);	
			return null;
		}
		
		public HybridCar getRealHybridCar(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (HybridCar)allVehicleTransportation.get(licensePlate);
			return null;
		}
		public HybridMotorcycle getRealHybridMotorcycle(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (HybridMotorcycle)allVehicleTransportation.get(licensePlate);
			return null;
		}
		public Motorcycle getRealMotorcycle(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (Motorcycle)allVehicleTransportation.get(licensePlate);
			return null;
		}
		public Car getRealCar(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (Car)allVehicleTransportation.get(licensePlate);
			return null;
		}
		public Van getRealVan(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (Van)allVehicleTransportation.get(licensePlate);
			return null;
		}
		public Customer getRealCustomer(String ID){
			if(allCustomers.get(ID) != null)
				return (Customer)allCustomers.get(ID);
			return null;
		}
		public Customer getRealVIPCustomer(String ID){
			if(allCustomers.get(ID) != null)
				return (VIPCustomer)allCustomers.get(ID);
			return null;
		}
		public Employee getRealEmployee(String ID){
			if(allEmployees.get(ID) != null)
				return (Employee)allEmployees.get(ID);
			return null;
		}
		public DepartmentManager getRealDepartmentManager(String ID){
			if(allEmployees.get(ID) != null)
				return (DepartmentManager)allEmployees.get(ID);
			return null;
		}

		public Deal getRealDeal(String dealID){
			if(allDeals.get(dealID)!=null) {
			return allDeals.get(dealID);
			}
			return null;
		}
		public Department getRealDepartment(int departmentID){
			if(allDepartments.get(departmentID)!=null) {
				return allDepartments.get(departmentID);
			}
			return null;
		}
		
	
		//Query functions 
		/** in customersByArea() we will return an hash map with all the customers living in the same area!
		 * @return toReturn */ 
		public HashMap<Area,ArrayList<Customer>> customersByArea(){
			HashMap<Area,ArrayList<Customer>> toReturn = new HashMap<Area, ArrayList<Customer>>();
			for(Area a: Area.values()) {
				toReturn.put(a, new ArrayList<Customer>());
			}
			for(Customer c : allCustomers.values()) {
				toReturn.get(c.getArea()).add(c);
			}
			return toReturn;
		}
		/**personsByGenderAndYearOfBirth() 
		 * @return allPeople an hash map that seperates male and female and in another hashmap sorting by year of birth! */ 
		public HashMap<Gender, HashMap <Integer, ArrayList<Person>>> personsByGenderAndYearOfBirth()
		{
			HashMap<Gender, HashMap <Integer, ArrayList<Person>>> toReturn = new HashMap<>();
			toReturn.put(Gender.F, new HashMap<>());
			toReturn.put(Gender.M, new HashMap<>());
			for(Person s: allCustomers.values()) {
				if(!toReturn.get(s.getGender()).containsKey(s.getYearOfBirth()))
				{
					toReturn.get(s.getGender()).put(s.getYearOfBirth(), new ArrayList<Person>());
				}
				toReturn.get(s.getGender()).get(s.getYearOfBirth()).add(s);
			}
			for(Person s: allEmployees.values()) {
				if(!toReturn.get(s.getGender()).containsKey(s.getYearOfBirth()))
				{
					toReturn.get(s.getGender()).put(s.getYearOfBirth(), new ArrayList<Person>());
				}
				toReturn.get(s.getGender()).get(s.getYearOfBirth()).add(s);
			}
			return toReturn;
		}
		/**countOfVehiclesTransportationByColor() 
		 * @return toReturn numOfColorsSold - an hash map of every color and how many cars sold from this color ! */
		public HashMap<Color, Integer> countOfVehiclesTransportationByColor(){
			HashMap<Color, Integer> toReturn = new HashMap<Color, Integer>();
			for(Color c : Color.values()) {
				toReturn.put(c, 0);
			}
			for(Deal d : allDeals.values()) {
				for(VehicleTransportation v : d.getAllVehicleTransportation()) {
					if(v != null)
						toReturn.put(v.getColor(), toReturn.get(v.getColor())+1);
				}
			}
			return toReturn;		
		}
		/** avgPollutionLevelOfDeal gets a deal and 
		 *@return (sum/deal.getAllVehicleTransportation().size() - the avg pollution level of that Deal! */ 
		public double avgPollutionLevelOfDeal(Deal deal) {
			if(deal==null)
				return -1;
			double sum;
			sum=deal.getAllVehicleTransportation().stream().mapToDouble(VehicleTransportation::getPollutionLevel).sum();
			return sum/deal.getAllVehicleTransportation().size();
		}
		
		/** using the preious method by running allDeals and 
		 * @return idNumber of the min pollutioning deal! */
		public String idOfDealWithMinAvgPollutionLevel() {	
			if(allDeals.isEmpty())
				return null;
			else {
				double minAvg=Double.MAX_VALUE;
				Deal d = allDeals.get("1");
				for(Deal temp : allDeals.values()) {
					if(avgPollutionLevelOfDeal(temp)<=minAvg & temp.getDealID().compareTo(d.getDealID())>0) {
						d = temp;
						minAvg = avgPollutionLevelOfDeal(d);
					} 
				}
				return d.getDealID();
			}
		}
		/** using the preious method by running allDeals and 
		 * @return d.getDealID idNumber of the min pollutioning deal! */
		public double avgPollutionLevelOfAllVehiclesTransportation()
		{
			double sum=0.0;
			for(VehicleTransportation v : allVehicleTransportation.values()) {
				sum += v.getPollutionLevel();
			}
			return (sum/allVehicleTransportation.size());	
		}
		/** in profitPerVehiclesTransportation we get the carPrice and substracting the manufaturing price from it!*/ 
		public Double profitPerVehiclesTransportation(VehicleTransportation vehicleTransportation) {
			if(vehicleTransportation == null)
				return  null;
			Stream<VehicleTransportation> vehi = Stream.of(vehicleTransportation);
			return vehi.mapToDouble(v->v.getPrice()-v.getCostOfManufacturing()).sum();
		}
		/** using the two previoues methods the check if our factory is in the wanted standarts!*/
		public boolean isGlobalStandard()
		{
			if(avgPollutionLevelOfAllVehiclesTransportation()<=5) {
				if(relativePrecentageOfHybrid()>=0.4)
					return true;
			}
			return false;
		}
		/**relativePrecentageOfHybrid () method gives us the proportion of the hybrid cars manufactured in our factory!**/
		public double relativePrecentageOfHybrid() {
			int countHybrid =0;
			for(VehicleTransportation v: allVehicleTransportation.values()) {
				if(v instanceof HybridCar || v instanceof HybridMotorcycle)
					countHybrid++;
			}
			return (double)countHybrid/allVehicleTransportation.size();	
		}
		/**using while loop and adding every time one more Hybrid car, until our factory matches the standartd! */
		public int howManyHybridVehiclesTransportationNeeded () {
			if(isGlobalStandard()==true) {
				return 0;
			}
			else {
				int countHybridVehicles=0 , countTotalVehicles = allVehicleTransportation.size() ,carsToAdd=0;
				double sumPollutionLevel=0;

				for(VehicleTransportation v: allVehicleTransportation.values()) {
					if(v instanceof HybridCar || v instanceof HybridMotorcycle)
						countHybridVehicles++;
					sumPollutionLevel += v.getPollutionLevel();
				}

				double rpOfHybrid = relativePrecentageOfHybrid();
				double avgPollution = avgPollutionLevelOfAllVehiclesTransportation();

				while( !(rpOfHybrid>=0.4 && avgPollution<=5) ) {
					carsToAdd++;
					sumPollutionLevel++;
					countHybridVehicles++;
					countTotalVehicles++;
					rpOfHybrid = (double)countHybridVehicles/countTotalVehicles;
					avgPollution = sumPollutionLevel / countTotalVehicles;
				}
				return carsToAdd;
			}
		}
		/** appointmentOfNewDepartmentManager checks first if there isnt any depManager to this dep*
		 *if there isn't any , so we will get the most senior worker and by depManager constructor we will apoint him,
		 *after that we will delete him from the employee job!
		 * @param department
		 * @return
		 * @throws ParseException
		 */
		
		public boolean appointmentOfNewDepartmentManager(Department department) throws ParseException {
			if(department==null) {
				return false;
			}
			LocalDateTime years=null;
				for(Map.Entry<String,Employee> entry : allEmployees.entrySet()) {
					if(entry.getValue() instanceof DepartmentManager) {
						if(entry.getValue().getDep().getDepartmentID()==department.getDepartmentID()) {
							return false;
						}
					}
				}
				Employee senior=null;
				for(Employee emp : department.getAllEmployees()) {
					if(years==null) {
						senior=emp;
						years=emp.getDateOfStartWork();
					}
					if(emp.getDateOfStartWork().isBefore(years)) {
						years=emp.getDateOfStartWork();
						senior=emp;
					}
				}
				LocalDateTime date = LocalDateTime.now();
				DepartmentManager NewManager = new DepartmentManager(senior.getID(),senior.getFirstName(),senior.getLastName(),senior.getPhoneNumber(),senior.getGender(),senior.getYearOfBirth()
						,senior.getDateOfStartWork(),senior.getSalary()*1.5,senior.getDep(),date,1500.0,senior.getPassword());
				allEmployees.remove(senior.getID());
				allEmployees.put(NewManager.getID(),NewManager);
				department.setDepManager(NewManager);
					return true;
				}
		/** in totalProfit we are summing the prices of the deals to sum by the totalDealPrice function, and taking the manufacture price from every single car, then returning total profit(revenue-expenses)*/
		public int totalProfit() {
			if(allDeals.isEmpty())
				return 0;
			List<Deal> deal = getAllDeals().values().stream()
					.collect(Collectors.toList());
			double revenue = deal.stream().mapToDouble(d->d.getTotalDealPrice()).sum();
			double costs = deal.stream().mapToDouble(d -> d.getAllVehicleTransportation().stream().mapToDouble(v->v.getCostOfManufacturing()).sum()).sum();
			return (int) (revenue-costs);

		}
		
		public HashMap<String, Employee> getAllEmployees() {
			return allEmployees;
		}

		public void setAllEmployees(HashMap<String, Employee> allEmployees) {
			this.allEmployees = allEmployees;
		}

		public HashMap<String, Customer> getAllCustomers() {
			return allCustomers;
		}

		public void setAllCustomers(HashMap<String, Customer> allCustomers) {
			this.allCustomers = allCustomers;
		}

		public HashMap<String, VehicleTransportation> getAllVehicleTransportation() {
			return allVehicleTransportation;
		}

		public void setAllVehicleTransportation(HashMap<String, VehicleTransportation> allVehicleTransportation) {
			this.allVehicleTransportation = allVehicleTransportation;
		}

		public HashMap<String, Deal> getAllDeals() {
			return allDeals;
		}

		public void setAllDeals(HashMap<String, Deal> allDeals) {
			this.allDeals = allDeals;
		}

		public HashMap<Integer, Department> getAllDepartments() {
			return allDepartments;
		}

		public void setAllDepartments(HashMap<Integer, Department> allDepartments) {
			this.allDepartments = allDepartments;
		}

		public static Factory getEnterpise() {
			return factory;
		}
		public static void setEnterpise(Factory enterpise) {
			Factory.factory = enterpise;
		}
		/**allEmployees method will return the k employees sorted 
		 * by their ID's! using the Compareable interface in the person Class */
		public List<Employee> allEmployees(int k){
			List<Employee> arr = getAllEmployees().values().stream().collect(Collectors.toList());
			Collections.sort(arr);
			if(k>=arr.size()) {
				return arr;
			}
			return arr.subList(0, k);
			}
	/**allCustomers well return us ArrayList of the customers sorted by their ID's 
	 * using the Compareable interface in the person Class */


		public ArrayList<Customer> allCustomers(){
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			for(Customer cust : allCustomers.values()) {
				customerList.add(cust);
			}
			Collections.sort(customerList);
			return customerList;
		}
		/**allVehicleTransportations will return a TreeSet of allVehicleTransportations
		 * sorted by their pollution level and the second sort by their prise(reversed!) 
		 * using here ComparePollution comparator*/
		public TreeSet<VehicleTransportation> allVehicleTransportations(){
			ComparePollution comPull =new ComparePollution();
			TreeSet<VehicleTransportation> tree = new TreeSet<VehicleTransportation>(comPull);
			for(VehicleTransportation vi : allVehicleTransportation.values()) {
				tree.add(vi);
			}
			return tree;
		}
		/** allCustomersCmp will return TreeSet of the customers first order by their deal's number
		 * second order by their total owned vehicles 
		 * using here DealCompare comparator*/
		public TreeSet<Customer> allCustomersCmp(){
			DealCompare comp = new DealCompare();
			TreeSet<Customer> tree = new TreeSet<Customer>(comp);
			for(Customer cust : allCustomers.values()) {
				tree.add(cust);
			}
			return tree;	
		}
		/**AllBestsDepManger will use CompareManager to compare the first order by their salary,
		 * and the second order by their appointment date - reversed! */
		public ArrayList<DepartmentManager> AllBestsDepManger(){
			List<DepartmentManager> temp = getAllEmployees().values().stream().filter(v-> v instanceof DepartmentManager).map(dm -> (DepartmentManager) dm).collect(Collectors.toList());
			Collections.sort(temp,new CompareManager());
			return (ArrayList<DepartmentManager>) temp;
		}
		/**getBestsDeal we are using the BestDealCompare comparator, by using the comparator constructor we are sending him 
		 * the score, and returning a list in size of k of the deals sorted! */
		public List<Deal> getBestsDeal(int k,ScoreCalculator score){
			List<Deal> deals = new ArrayList<Deal>();
			List<Deal> dealsNew = new ArrayList<Deal>();
			for(Deal deal : allDeals.values()) {
				deals.add(deal);
			}
			Collections.sort(deals,new BestDealCompare(score));
			for(int i=0;i<k;i++) {
				dealsNew.add(deals.get(i));
			}
			return dealsNew;
			
		}
}	
