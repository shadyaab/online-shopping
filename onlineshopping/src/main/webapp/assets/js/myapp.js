$(function(){
	//solving the active menu problem
	switch(menu){
		
		case "About Us":
			$('#about').addClass('active');
			break;
		case "Contact Us":
			$('#contact').addClass('active');
			break;
		case "All Products":
			$('#listProducts').addClass('active');
			break;	
		case "Manage Products":
			$('#manageProducts').addClass('active');
			break;
		default : 
			$('#home').addClass('active');
			$('#a_' + menu).addClass('active');
			 break;
	}
	
	
	//Code for jQuery datatable
	//create a dataset
	
	var $table = $('#productListTable');
	if($table.length){
		debugger;
		var jsonUrl = '';
		if(window.categoryId == ''){
			var jsonUrl = window.contextRoot + '/json/data/all/products';
		} else{
			var jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		$table.DataTable({
			lengthMenu : [[3,5,10, -1],['3 records', '5 record', '10 records', 'all']],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : '',
				
			},
			columns : [
				{
					data : 'name',
				},
				{
					data : 'brand',
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row){
						return '&#8377; ' + data
					}
				},
				{
					data : 'quantity',
				},
				{
					data : 'id',
					bSortable: false,
					mRender : function(data, type, row){
						var str = '';
						
						str += '<a href="' + window.contextRoot + '/show/' + data + '/product">View</a>';
						str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product">Add to Cart</a>';
						return str;
					}
				}
			]
		})
		
		
	}
	
	
});











