$(() => {
    console.log("inside posts.js");
    let request = $.ajax({'url': '/posts.json'});
    request.done(posts => {
        let html = '';
        posts.forEach(post => {
            html += `
            <div>
                <h1>${post.title}</h1>
                <p>${post.body}</p>
                <p>Created by ${post.user.username}</p>
            </div>
            `;
        });
        $('#posts').html(html);
    });
});