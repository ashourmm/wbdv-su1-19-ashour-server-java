(function () {

    const $elem = $('.container-fluid');
    const $createBtn = $('#createBtn');
    const $usernameFld = $('#usernameFld');
    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const $lastNameFld = $('#lastNameFld')
    const userRowTemplate = $('.userRowTemplate');
    const $roleFld = $('#role');
    const tbody = $('tbody');
    const $deleteBtn = $('.deleteBtn')
    const findAllUsersUrl = 'http://localhost:8080/users'
    const deleteUserUrl = 'http://localhost:8080/users/USER_ID'
    const userService = new UserService()

    $.ajax(findAllUsersUrl, {
        'success': handleUsers
    })

    function handleUsers(users) {
        $("tbody tr").remove();
        for(var u = 0; u < users.length; u++) {
            appendUserToDom(users[u]);
        }
    }

    $elem.append('<h1>Welcome to jQuery</h1>')

    $createBtn.click(createUser)
    $deleteBtn.click(deleteUser)

    function deleteUser(event) {
        deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr('id')
        userService
            .deleteUser(id)
            .then(handleUsers);
        // const tr = currentTarget.parent().parent()
        // console.log(tr)
        // tr.remove()
    }

    function createUser(event) {
        //console.log('createUser')
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
            .then(handleUsers)

        // appendUserToDom(user)
    }

    function selectUser(event) {
        //var currentTarget = $(event.currentTarget);
    }

    function appendUserToDom(user) {
        const row = userRowTemplate.clone();
        row.removeClass('d-none')
        const usernameCol = row.find('.usernameCol');
        const passwordCol = row.find('.passwordCol');
        const firstNameCol = row.find('.firstNameCol');
        const lastNameCol = row.find('.lastNameCol')
        //TODO: add lastNameCol
        //TODO: add role
        const roleCol = row.find('roleCol')
        const deleteBtn = row.find('.deleteBtn');
        const editBtn = row.find('editBtn').click(selectUser);
        deleteBtn.click(deleteUser);
        deleteBtn.attr('id', user.id);
        usernameCol.html(user.username);
        passwordCol.html(user.password);
        firstNameCol.html(user.firstName);
        lastNameCol.html(user.lastName);
        roleCol.html(user.role)
        tbody.append(row)
    }


})()