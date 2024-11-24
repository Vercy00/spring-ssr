window.onload = () => {
    const el = document.getElementById("list")

    el.innerHTML = "Loading..."

    setTimeout(() => {
        fetch("/api/posts")
            .then((res) => res.json())
            .then((data) => {
                let html = "";

                for (const post of data)
                    html += `<div class="item">
        <img class="art-image" src="${post.imageUrl}" alt=""/>
        <div class="text">
            <div class="art-header">
                <h2 class="art-title">${post.title}</h2>
                <div>-</div>
                <div>${post.user.username}</div>
            </div>
            <p class="art-content">${post.content}</p>
        </div>
    </div>`

                el.innerHTML = html
            })
    }, 2000)
}