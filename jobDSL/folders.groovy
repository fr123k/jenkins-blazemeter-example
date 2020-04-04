views = [
    [
        name: "blazemeter",
        description: "Blazemeter Examples",
        projects: [
            "blazemeter",
        ],
    ],
]

for(view in views) {
    folder("${view.name}") {
        description("${view.name} jobs")
    }

    listView("${view.name}") {
        description("${view.description}")
        filterBuildQueue()
        filterExecutors()
        jobs {
            for(project in view.projects) {
                name("${project}")
            }
        }
        columns {
            status()
            weather()
            name()
            lastSuccess()
            lastFailure()
            lastDuration()
            buildButton()
        }
    }
}
