
var restaurantLibelle = ""

$('#btn-update').on('click', function () {
    $restaurantRate = $('#rate').val()
    $('#rate-modal').modal('hide')

    $.ajax({
        url : '/rate',
        data: JSON.stringify({libelle: restaurantLibelle, rate: $restaurantRate}),
        method: 'post',
        contentType: 'application/json',
        complete: function (data) {
            location.reload(true)
        }
    })
})

function update(restaurant) {
    restaurantLibelle = restaurant
    $('.modal-title').text(restaurantLibelle)
    $('#rate-modal').modal('show')
}
