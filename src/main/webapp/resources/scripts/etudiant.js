	$('#b').hide();
	$('#del').hide();
	$('#a').click(function(){
		$('#b').show();
		$(this).hide();
	});
	$('#b').click(function(){
		$('#a').show();
		$(this).hide();
	});
	
	$('.remove').each(function(){
		$(this).click(function(){
			var texte = $(this).attr('href');
			var tab = texte.split('|');
			$('#modalLabel').text("Suppression de "+ tab[1]);
			$('#modalBody').text("Voulez vraiment supprimer cet étudiant ?");
			$('#delete').click(function(){
				var id = tab[0];
				var adresse = "/gnote/supprimerEtudiant/"+id;
				$.ajax({
					type: 'GET',
					url : adresse,
					success: function(data){
						$('#del').text("L'étudiant "+data.nom+" a été supprimé avec succuès !");
						$('#del').fadeIn(2000);
						$('#del').fadeOut(2000);
						//window.setTimeout(location.reload(true), 5000);
						location.reload(true);
						//$('#etu'+data.id_etudiant).hide();
					},
					error: function(){
						alert("Error occured !");
					}
				});
			});
		});
	});
	
	$('#ok').fadeOut(2000);