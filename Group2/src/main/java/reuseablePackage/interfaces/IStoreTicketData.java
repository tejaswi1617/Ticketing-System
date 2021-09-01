package reuseablePackage.interfaces;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public interface IStoreTicketData
{
	public boolean addFetchedTickets(ResultSet resultSet, ResultSetMetaData tableMetaData);
	public boolean addFetchedComments(ResultSet resultSet);
	public LinkedHashMap<String, ArrayList<String>> getTableData();
	public ArrayList<String> getSingleTicketData(String TicketID);
	public List<String> getTicketColumns();
	public List<String> getcommentsOnTicket();
}
