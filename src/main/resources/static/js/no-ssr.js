window.onload = () => {
    const el = document.getElementById("users")

    el.innerHTML = "Loading..."

    setTimeout(() => {
        fetch("/api/users")
            .then((res) => res.json())
            .then((data) => {
                let html = "";

                for (const user of data)
                    html += `<div>${user.username}</div>`

                el.innerHTML = html
            })
    }, 2000)
}