package reuseablePackage.interfaces;

import java.util.List;


public interface ITableGenerator 
{
	public String generateTable(List<String> headersList, List<List<String>> rowsList,int... overRiddenHeaderHeight);

}
