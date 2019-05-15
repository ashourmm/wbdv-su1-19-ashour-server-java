(function () {

    const $createBtn = $('#createBtn');
    const $editBtn = $('.editBtn');
    const $updateBtn = $('#updateBtn');
    const $deleteBtn = $('.deleteBtn')
    const $usernameFld = $('#usernameFld');

    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const $lastNameFld = $('#lastNameFld');
    const userRowTemplate = $('.userRowTemplate');
    const $roleFld = $('#role');

    const tbody = $('tbody');

    const findAllUsersUrl = 'http://blooming-fortress-89013.herokuapp.com/users'
    //const deleteUserUrl = 'http://blooming-fortress-89013.herokuapp.com/users/USER_ID'
    const userService = new UserService()

    $.ajax(findAllUsersUrl, {
        'success': renderUsers
    })

    function findAllUsers() {
        $.ajax(findAllUsersUrl, {
            'success': renderUsers
        })
    }

    $createBtn.click(createUser);
    $deleteBtn.click(deleteUser);
    $editBtn.click(selectUser);
    $updateBtn.click(updateUser);

    function renderUsers(users) {
        $("tbody tr").remove();
        for (var u = 0; u < users.length; u++) {
            renderUser(users[u]);
        }
    }

    function findUserById(id) {
        userService.findUserById(id);
    }

    function updateUser(event) {
        const updateBtn = $(event.currentTarget);

        const username = $usernameFld.val()
        const password = $passwordFld.val()
        const firstName = $firstNameFld.val()
        const lastName = $lastNameFld.val()
        const role = $roleFld.val();
        const id = $updateBtn.attr('id')

        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
            //TODO: add role
        }

        userService
            .updateUser(id, user)
            .then(findAllUsers);
    }


    function deleteUser(event) {
        deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr('id')
        userService
            .deleteUser(id)
            .then(findAllUsers);
    }

    function createUser(event) {
        const username = $usernameFld.val()
        const password = $passwordFld.val()
        const firstName = $firstNameFld.val()
        const lastName = $lastNameFld.val()
        const role = $roleFld.val();
        console.log(username, password, firstName, role)

        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
            //TODO: add role
        }

        userService
            .createUser(user)
            .then(findAllUsers)
    }

    function selectUser(event) {
    	const edit = $(event.currentTarget);
        const userName = edit.attr('userNameCol');
        const firstName = edit.attr('firstNameCol');
        const lastName = edit.attr('lastNameCol');
        const role = edit.attr('roleCol');
        const id = edit.attr('id');
        $updateBtn.attr('id', id)
        console.log(userName, firstName, lastName, role);
        $usernameFld.val(userName);
        $firstNameFld.val(firstName);
        $lastNameFld.val(lastName);
        $roleFld.val(role);

        const user = {
            username: userName,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        }


    }

    function renderUser(user) {
        const row = userRowTemplate.clone();
        row.removeClass('d-none')
        const usernameCol = row.find('.usernameCol');
        const passwordCol = row.find('.passwordCol');
        const firstNameCol = row.find('.firstNameCol');
        const lastNameCol = row.find('.lastNameCol')
        const roleCol = row.find('roleCol')
        const deleteBtn = row.find('.deleteBtn');
        const editBtn = row.find('.editBtn').click(selectUser);
        editBtn.attr('userNameCol', user.username);
        editBtn.attr('id', user.id);
        deleteBtn.click(deleteUser);
        deleteBtn.attr('id', user.id);
        deleteBtn.click(deleteUser);
        usernameCol.html(user.username);
        passwordCol.html(user.password);
        firstNameCol.html(user.firstName);
        lastNameCol.html(user.lastName);
        roleCol.html(user.role)
        tbody.append(row)
    }
})()