package pt.up.fe.ldts.example5

import spock.lang.Specification

class TurtleSpockTest extends Specification {

    def 'Rotate Left'() {
        given:
        def turtle = new Turtle(5, 5, new North(null))

        when:
        turtle.execute('L' as char)

        then:
        turtle.getDirection() in West

        and:
        turtle.execute('L' as char)

        then:
        turtle.getDirection() in South

        and:
        turtle.execute('L' as char)

        then:
        turtle.getDirection() in East

        and:
        turtle.execute('L' as char)

        then:
        turtle.getDirection() in North

        and:
        5 == turtle.getRow()
        5 == turtle.getColumn()
    }

    def 'Rotate Right'() {
        given:
        def turtle = new Turtle(5, 5, new North(null)) {}

        when:
        turtle.execute('R' as char)

        then:
        turtle.getDirection() in East

        and:
        turtle.execute('R' as char)

        then:
        turtle.getDirection() in South

        and:
        turtle.execute('R' as char)

        then:
        turtle.getDirection() in West

        and:
        turtle.execute('R' as char)

        then:
        turtle.getDirection() in North

        and:
        5 == turtle.getRow()
        5 == turtle.getColumn()
    }

    def 'Forward'() {
        given:
        def turtleN = new Turtle(5, 5, new North(null))
        def turtleW = new Turtle(5, 5, new West(null))
        def turtleS = new Turtle(5, 5, new South(null))
        def turtleE = new Turtle(5, 5, new East(null))

        when:
        turtleN.execute('F' as char)
        turtleW.execute('F' as char)
        turtleS.execute('F' as char)
        turtleE.execute('F' as char)

        then:
        4 == turtleN.getRow()
        5 == turtleN.getColumn()

        and:
        5 == turtleW.getRow()
        4 == turtleW.getColumn()

        and:
        6 == turtleS.getRow()
        5 == turtleS.getColumn()

        and:
        5 == turtleE.getRow()
        6 == turtleE.getColumn()
    }
}