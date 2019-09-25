//When inStock is false, bind a class to the “Out of Stock” p tag that adds  text-decoration: line-through to that element.

var app = new Vue({
	el: '#app',
	data: {
		activeMode: 'Add',
		modes: ['Add', 'View'],
		activeArea: 'location',
		locations: [],
		selectedLocation: null,
		creatingNewLocation: false,
		product: 'Socks',
		image: 'https://www.vuemastery.com/images/challenges/vmSocks-green-onWhite.jpg',
		inStock: false,
		details: ['80% cotton', '20% polyester', 'Gender-neutral'],
		variants: [{
			variantId: 2234,
			variantColor: 'green',
			variantImage: 'https://www.vuemastery.com/images/challenges/vmSocks-green-onWhite.jpg'
		}, {
			variantId: 2235,
			variantColor: 'blue',
			variantImage: 'https://www.vuemastery.com/images/challenges/vmSocks-blue-onWhite.jpg'
		}],
		cart: 0
	},
	methods: {
		switchMode(newMode) {
			this.activeMode = newMode
		},
		clickNewLocation() {
			this.creatingNewLocation = true
		},
		clickAddNewLocation() {
			var location_name = document.getElementById('new-location-name');
			if (location_name.value) {
				var newLocation = {
					name: location_name.value
				};
				this.locations.push(newLocation);
				this.switchLocation(newLocation);
			}
			this.creatingNewLocation = false
		},
		switchLocation(location) {
			this.selectedLocation = location;
		},
		addToCart() {
			this.cart += 1
		},
		updateProduct(variantImage) {
			this.image = variantImage
		},

	}
})
