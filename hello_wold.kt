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
        sshpass -p SERVER_PASS ssh SERVER_LOGIN@SERVER_IP << EOF
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
