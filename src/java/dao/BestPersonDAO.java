package dao;

import dto.BestPerson;
import java.util.List;

public interface BestPersonDAO {
    
    public List<BestPerson> getList();
    
    public BestPerson getBestPerson(String cod);
    
}
