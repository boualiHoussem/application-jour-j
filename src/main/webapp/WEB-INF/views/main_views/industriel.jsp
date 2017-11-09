<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>FCEE 7eme Edition</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/menu/menu.jsp"%>
	<div id="page-wrapper">

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Industriels</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Liste des industriels inscrits</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Pr�nom</th>
								<th>Poste</th>
								<th>Entreprise</th>
								<th>N� Telephone</th>
								<th>E-mail</th>
							</tr>
						</thead>
						<tbody>
							<tr class="odd gradeX">
								<c:forEach items="${industriels }" var="indus">
									<td>${indus.getNom() }</td>
									<td>${indus.getPrenom() }</td>
									<td>${indus.getPoste() }</td>
									<td class="center">${indus.getEntreprise() }</td>
									<td class="center">${indus.getNumeroTelephone() }</td>
									<td>${indus.getEmail() }</td>
								</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>
</body>
</html>
