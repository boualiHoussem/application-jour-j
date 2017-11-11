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
</head>
<body>
	<%@ include file="/WEB-INF/views/menu/menu.jsp"%>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Enseignants</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<c:url value="/enseignant/add" var="ajouterEnseignant" />
				<li class="breadcrumb-item"><a href="${ajouterEnseignant }">Ajouter</a></li>
				<li class="breadcrumb-item"><a href="#">Library</a></li>
				<li class="breadcrumb-item active" aria-current="page">Data</li>
			</ol>
		</nav>
		<!-- /.row -->
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Liste des enseignants inscrits</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Pr�nom</th>
								<th>Grade</th>
								<th width="80px">Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${enseignants }" var="enseignant">
								<tr class="odd gradeX">
									<td class="center">${enseignant.getNom() }</td>
									<td class="center">${enseignant.getPrenom() }</td>
									<td>${enseignant.getGrade() }</td>
									<c:url value="/enseignant/edit/${enseignant.getIdProfessor() }"
										var="url_edit" />
									<td><a href="${url_edit }" title="Modifier"><i
											class="glyphicon glyphicon-edit"></i></a>&ensp; &ensp;&ensp; <a
										href="javascript:void(0);" data-toggle="modal" data-target="#modalEnseingnant${enseignant.getIdProfessor() }"
										title="Supprimer"><i class="glyphicon glyphicon-trash"></i></a>
										<div class="modal fade" id="modalEnseingnant${enseignant.getIdProfessor() }" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title" id="myModalLabel">Supprimer</h4>
													</div>
													<div class="modal-body">Voulez vous supprimer ${enseignant.getNom() } !</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-primary"
															data-dismiss="modal">Annuler</button>
														<c:url value="/enseignant/delete/${enseignant.getIdProfessor() }" var="url_del" />
														<a href="${url_del }" class="btn btn-danger">Confirmer
														</a>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div></td>
								</tr>
							</c:forEach>
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
</body>
</html>
