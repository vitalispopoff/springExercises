<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Customer Confirmation.</title>
	</head>

	<body>
		The customer <i>${customer.firstName} ${customer.lastName}</i> is confirmed now.
		
		<br><br>
		
		Free passes: ${customer.freePasses}
		
		<br><br>
		
		Postal code <i>${customer.postalCode}</i> is confirmed.		
		
		<br><br>
		
	</body>
</html>