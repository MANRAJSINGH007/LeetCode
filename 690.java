/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    
    public static int employeeImportance(HashMap<Integer, Employee> employees, int curr, HashSet<Integer> visited){
        
        visited.add(curr);
        int imp = employees.get(curr).importance;
        
        for(int i = 0; i < employees.get(curr).subordinates.size(); i++){
            if(!visited.contains(employees.get(curr).subordinates.get(i))){
                imp += employeeImportance(employees, employees.get(curr).subordinates.get(i), visited);
            }
        }
        
        return imp;
        
    }
    
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(int i = 0; i < employees.size(); i++){
            int uid = employees.get(i).id;
            map.put(uid, employees.get(i));
        }
        
        return employeeImportance(map, id, new HashSet<>());
    }
}
