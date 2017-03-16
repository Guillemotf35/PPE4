<?php

namespace GarderieBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Presence
 *
 * @ORM\Table(name="presence")
 * @ORM\Entity(repositoryClass="GarderieBundle\Repository\PresenceRepository")
 */
class Presence
{

    /**
    * @ORM\ManyToOne(targetEntity="GarderieBundle\Entity\enfant")
    * @ORM\JoinColumn(nullable=false)
    */
    private $enfant;

    /**
    * @ORM\ManyToOne(targetEntity="GarderieBundle\Entity\jour")
    * @ORM\JoinColumn(nullable=false)
    */
    private $jour;

    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="heureArriveeMatin", type="string", length=255)
     */
    private $heureArriveeMatin;

    /**
     * @var string
     *
     * @ORM\Column(name="heureDepartSoir", type="string", length=255)
     */
    private $heureDepartSoir;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date")
     */
    private $date;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set heureArriveeMatin
     *
     * @param string $heureArriveeMatin
     *
     * @return Presence
     */
    public function setHeureArriveeMatin($heureArriveeMatin)
    {
        $this->heureArriveeMatin = $heureArriveeMatin;

        return $this;
    }

    /**
     * Get heureArriveeMatin
     *
     * @return string
     */
    public function getHeureArriveeMatin()
    {
        return $this->heureArriveeMatin;
    }

    /**
     * Set heureDepartSoir
     *
     * @param string $heureDepartSoir
     *
     * @return Presence
     */
    public function setHeureDepartSoir($heureDepartSoir)
    {
        $this->heureDepartSoir = $heureDepartSoir;

        return $this;
    }

    /**
     * Get heureDepartSoir
     *
     * @return string
     */
    public function getHeureDepartSoir()
    {
        return $this->heureDepartSoir;
    }

    /**
     * Set date
     *
     * @param \DateTime $date
     *
     * @return Presence
     */
    public function setDate($date)
    {
        $this->date = $date;

        return $this;
    }

    /**
     * Get date
     *
     * @return \DateTime
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * Set enfant
     *
     * @param \OC\PlatformBundle\Entity\enfant $enfant
     *
     * @return Presence
     */
    public function setEnfant(\OC\PlatformBundle\Entity\enfant $enfant)
    {
        $this->enfant = $enfant;

        return $this;
    }

    /**
     * Get enfant
     *
     * @return \OC\PlatformBundle\Entity\enfant
     */
    public function getEnfant()
    {
        return $this->enfant;
    }

    /**
     * Set jour
     *
     * @param \OC\PlatformBundle\Entity\jour $jour
     *
     * @return Presence
     */
    public function setJour(\OC\PlatformBundle\Entity\jour $jour)
    {
        $this->jour = $jour;

        return $this;
    }

    /**
     * Get jour
     *
     * @return \OC\PlatformBundle\Entity\jour
     */
    public function getJour()
    {
        return $this->jour;
    }
}
