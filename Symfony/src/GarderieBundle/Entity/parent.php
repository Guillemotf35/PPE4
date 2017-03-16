<?php

namespace GarderieBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * parent
 *
 * @ORM\Table(name="parent")
 * @ORM\Entity(repositoryClass="GarderieBundle\Repository\parentRepository")
 */
class parent
{

    /**
    * @ORM\ManyToOne(targetEntity="OC\GarderieBundle\Entity\tarif")
    * @ORM\JoinColumn(nullable=false)
    */
    private $tarif;

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
     * @ORM\Column(name="nom", type="string", length=255)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=255)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="telephone", type="string", length=255)
     */
    private $telephone;

    /**
     * @var string
     *
     * @ORM\Column(name="QF", type="string", length=255)
     */
    private $qF;


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
     * Set nom
     *
     * @param string $nom
     *
     * @return parent
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prenom
     *
     * @param string $prenom
     *
     * @return parent
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;

        return $this;
    }

    /**
     * Get prenom
     *
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * Set telephone
     *
     * @param string $telephone
     *
     * @return parent
     */
    public function setTelephone($telephone)
    {
        $this->telephone = $telephone;

        return $this;
    }

    /**
     * Get telephone
     *
     * @return string
     */
    public function getTelephone()
    {
        return $this->telephone;
    }

    /**
     * Set qF
     *
     * @param string $qF
     *
     * @return parent
     */
    public function setQF($qF)
    {
        $this->qF = $qF;

        return $this;
    }

    /**
     * Get qF
     *
     * @return string
     */
    public function getQF()
    {
        return $this->qF;
    }
}

