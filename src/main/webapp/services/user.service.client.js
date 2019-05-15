function UserService() {

    this.deleteUserUrl = 'http://blooming-fortress-89013.herokuapp.com/users/USER_ID';
    this.updateUserUrl = 'http://blooming-fortress-89013.herokuapp.com/users/USER_ID';
    this.findAllUsersUrl = 'http://blooming-fortress-89013.herokuapp.com/users';
    
    this.createUser = function (user) {
        user.id = (new Date()).getTime();
        console.log(user);
        return fetch("http://blooming-fortress-89013.herokuapp.com/users", {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json()
        })
    }

    this.findAllUsers = function (handleUsers) {
        $.ajax(this.findAllUsersUrl, {
            'success': handleUsers
        })
    }

    this.updateUser = function (id, user) {
        return fetch(this.updateUserUrl.replace('USER_ID', id),
            {
                method: 'PUT',
                body: JSON.stringify(user),
                headers: {
                    'content-type': 'application/json'
                }
            }).then(function(response) {
            return response.json
        })
    }

    this.findUserById = function findUserById() {}

    this.deleteUser = function(id) {
        return fetch(this.deleteUserUrl.replace('USER_ID', id), {
            method: 'DELETE'
        }).then(function(response) {
            return response.json();
        })
    }
}