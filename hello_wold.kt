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
        sshpass -p env.SERVER_PASS ssh env.SERVER_LOGIN@env.SERVER_IP << EOF
        echo "hello, cruel world!" > hello_wold.txt
        EOF
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
