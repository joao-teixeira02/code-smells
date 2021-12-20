package pt.up.fe.ldts.example6

import spock.lang.Specification
import java.text.SimpleDateFormat

class TreeSpockTest extends Specification {
    def tree
    def treeLocation
    def date

    def setup() {
        def sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
        date = sdf.parse("31-08-2002 10:20:56")
        treeLocation = new Location(date, "41.177772696363114", "-8.59843522310257", "FEUP")
        tree = new Tree()
    }

    def 'Tree Creation'() {
        expect:
        treeLocation.plantedAt == date
        treeLocation.locationLatitude == "41.177772696363114"
        treeLocation.locationLongitude == "-8.59843522310257"
        treeLocation.locationName == "FEUP"
    }

    def 'Tree Set Location'() {
        given:
        treeLocation.setLocation("loclat", "loclon", "locname")

        expect:
        treeLocation.plantedAt == date
        treeLocation.locationLatitude == "loclat"
        treeLocation.locationLongitude == "loclon"
        treeLocation.locationName == "locname"
    }

    def 'Tree to String'() {
        when:
        def result = treeLocation.toString()

        then:
        result == "Tree planted at Sat Aug 31 10:20:56 WEST 2002 in location 41.177772696363114,-8.59843522310257 (FEUP)"
    }

    def 'Add Appraisal'() {
        when:
        def sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss")
        def appraisalDate = sdf.parse("31-08-2002 10:20:56")

        then:
        tree.getAppraisals().size() == 0

        and:
        tree.addAppraisal(appraisalDate)

        then:
        tree.getAppraisals().size() == 1
    }

    def 'Next Appraisal Overdue'() {
        given:
        def calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        calendar.add(Calendar.MONTH, -6)

        when:
        def appraisalDate = calendar.getTime()

        then:
        !tree.isNextAppraisalOverdue()

        and:
        tree.addAppraisal(appraisalDate)

        then:
        tree.isNextAppraisalOverdue()
    }

    def 'Next Appraisal Not Overdue'() {
        given:
        def calendar = Calendar.getInstance()
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);

        when:
        def appraisalDate = calendar.getTime()

        then:
        !tree.isNextAppraisalOverdue()

        and:
        tree.addAppraisal(appraisalDate)

        then:
        !tree.isNextAppraisalOverdue()
    }
}