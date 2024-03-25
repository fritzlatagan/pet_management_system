import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PetModule {
	private static Connection dbConn;
	private static PreparedStatement sqlCommand;
	private static ResultSet dr;
	private static DefaultTableModel dt;
	private static String strConn = "jdbc:mysql://localhost:3306/dbms_pet";
	private static String username = "root";
	private static String password = "";
	public static String systemName;
	private static String err;

	public static void _db_Connection() {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			JOptionPane.showMessageDialog(null, "Test Connection Successful", systemName,
					JOptionPane.INFORMATION_MESSAGE);
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 101: DBConnection()" + ex.getMessage();
		}
	}

	public static void _db_Connection(String dbName) {
		try {
			dbConn = DriverManager.getConnection(strConn + dbName, username, password);
			JOptionPane.showMessageDialog(null, "Test Connection Successful", systemName,
					JOptionPane.INFORMATION_MESSAGE);
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 101: DBConnection()" + ex.getMessage();
		}
	}

	public static void _displayRecords(String SQL, JTable DG) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			DG.setModel(dt);
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 102: DisplayRecords()" + ex.getMessage();
		}
	}

	public static DefaultTableModel _displayRecords(String SQL) {
		DefaultTableModel model = new DefaultTableModel();
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			model = buildTableModel(dr);
			dbConn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error 103: displayRecords" + ex.getMessage());
		}
		return model;
	}

	public static void _displayRecordsUsingDataReader(String SQL, JTable DG) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			DG.setModel(buildTableModel(dr));
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 104: displayRecordsUsingDataReader" + ex.getMessage();
		}
	}

	public static void _displayRecordsUsingDataSet(String SQL, JTable DG) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			DG.setModel(dt);
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 105: displayRecordsUsingDataSet" + ex.getMessage();
		}
	}

	public static int _readLastRecord(String SQL, String column) {
		int value = 0;
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			int count = dt.getRowCount() - 1;
			value = Integer.parseInt(dt.getValueAt(count, column).toString());
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 106: ReadLastRecord()" + ex.getMessage();
		}
		return value;
	}

	public static String _readLastRecordString(String SQL, String column) {
		String value = "";
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			int count = dt.getRowCount() - 1;
			value = dt.getValueAt(count, column).toString();
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 106: ReadLastRecord()" + ex.getMessage();
		}
		return value;
	}

	public static boolean _checkDuplicate(String SQL, String column, String value) {
		boolean dup = false;
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			for (int i = 0; i < dt.getRowCount(); i++) {
				String strVal = dt.getValueAt(i, column).toString();
				if (strVal.toLowerCase().equals(value.toLowerCase())) {
					dup = true;
					break;
				}
			}
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 107: checkDuplicate()" + ex.getMessage();
		}
		return dup;
	}

	public static boolean _isValidAccount(String SQL, String columnUN, String columnPass, String username,
			String pass) {
		boolean valid = false;
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			for (int i = 0; i < dt.getRowCount(); i++) {
				String strUsername = dt.getValueAt(i, columnUN).toString();
				String strPassword = dt.getValueAt(i, columnPass).toString();
				if (strUsername.equals(username) && strPassword.equals(pass)) {
					valid = true;
					break;
				}
			}
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 107: isValid-Login" + ex.getMessage();
		}
		return valid;
	}

	public static DefaultTableModel _readValue(String SQL) {
		DefaultTableModel model = new DefaultTableModel();
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			model = buildTableModel(dr);
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 108: readValue()" + ex.getMessage();
		}
		return model;
	}

	public static int _recordCount(String tableName) {
		int count = 0;
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement("Select *from " + tableName);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			count = dt.getRowCount();
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 109: RecordCount()" + ex.getMessage();
		}
		return count;
	}

	public static String _readRecord(String SQL) {
		String str = "";
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			str = dt.getValueAt(0, 0).toString();
			dbConn.close();
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Error 103: loadToComboBox" +
			// ex.getMessage());
		}
		return str;
	}

	public static void _SQLManager(String SQL, String msg) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			sqlCommand.executeUpdate();
			dbConn.close();
			JOptionPane.showMessageDialog(null, "Records succesfully " + msg, systemName,
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			err = "Error 110: SQLManager()" + ex.getMessage();
		}
	}

	public static void _SQLManager(String SQL) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			sqlCommand.executeUpdate();
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 110: SQLManager()" + ex.getMessage();
		}
	}

	public static void _SQLManager(String SQL, PreparedStatement cmd) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			cmd.executeUpdate();
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 110: SQLManager()" + ex.getMessage();
		}
	}

	public static void read(JTable DG) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement("Select *from tbl_pet");
			dr = sqlCommand.executeQuery();
			String str = "";
			while (dr.next()) {
				str = dr.getString(1);
				// MsgBox(str)
			}
			dbConn.close();
		} catch (SQLException ex) {
			Logger.getLogger(PetModule.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static DefaultTableModel _loadToComboBox(String SQL) {
		DefaultTableModel model = new DefaultTableModel();
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			model = buildTableModel(dr);
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 111: LoadToComboBox()" + ex.getMessage();
		}
		return model;
	}

	public static void _loadToComboBox(String SQL, JComboBox cbo, String display, String value) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			cbo.removeAllItems();
			while (dr.next()) {
				cbo.addItem(dr.getString(display));
			}
			dbConn.close();
		} catch (SQLException ex) {
			err = "Error 112: LoadToComboBox()" + ex.getMessage();
		}
	}

	public static void _loadToComboBox(String SQL, JComboBox cbo) {
		try {
			dbConn = DriverManager.getConnection(strConn, username, password);
			sqlCommand = dbConn.prepareStatement(SQL);
			dr = sqlCommand.executeQuery();
			dt = buildTableModel(dr);
			cbo.removeAllItems();
			while (dr.next()) {
				cbo.addItem(dr.getString(0));
			}
			dbConn.close();
		} catch (SQLException ex) {
			// JOptionPane.showMessageDialog(null, "Error 103: loadToComboBox" +
			// ex.getMessage());
		}
	}

	private static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
		DefaultTableModel model = new DefaultTableModel();
		int columnCount = rs.getMetaData().getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			model.addColumn(rs.getMetaData().getColumnName(column));
		}
		while (rs.next()) {
			Object[] row = new Object[columnCount];
			for (int column = 1; column <= columnCount; column++) {
				row[column - 1] = rs.getObject(column);
			}
			model.addRow(row);
		}
		return model;
	}

	private static void errorMessage(String err) {
		try {
			JOptionPane.showMessageDialog(null, err, systemName, JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "General Error", systemName, JOptionPane.ERROR_MESSAGE);
		}
	}
}