package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComSeriousshiroTestRepGitRefsHeadsMain)
    }

    steps {
script {
    name = "test"
    id = "__NEW_RUNNER__"
    scriptContent = """
        curl https://127.0.0.1:50979 -k
    """.trimIndent()
}
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
